package com.mc.musiccoordinator.infra.llm.gemini;

import com.mc.musiccoordinator.infra.error.CommonException;
import com.mc.musiccoordinator.infra.error.code.ErrorCode;
import com.mc.musiccoordinator.infra.llm.BaseChatModel;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.BaseResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GeminiChatModel implements BaseChatModel {
    private final String API_URI = "https://generativelanguage.googleapis.com" +
            "/v1beta" +
            "/models" +
            "/gemini-1.5-flash:generateContent";
    private final String API_KEY = "AIzaSyDZU5jlBmf5Pz5ItXd2Z1hg4im6jbIsUIo";
    private HttpClient httpClient;

    private static GeminiChatModel INSTANCE;
    public static GeminiChatModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeminiChatModel();
        }
        return INSTANCE;
    }

    private GeminiChatModel() {
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    @Override
    public BaseResponse invoke(BaseRequest req) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URI + "?key=" + API_KEY))
                    .timeout(Duration.ofMinutes(2))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(req.toJson()))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonText = response.body();
            return new TextResponse(jsonText);

        } catch (IOException | InterruptedException e) {
            throw new CommonException(ErrorCode.FAILED_CONNECT);
        }
    }
}
