package com.mc.musiccoordinator.domain.coordinator;

import com.mc.musiccoordinator.domain.qr.QRCodeGenerator;
import com.mc.musiccoordinator.domain.song.SongMessage;
import com.mc.musiccoordinator.infra.llm.BaseChatModel;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.ResponseFormat;
import com.mc.musiccoordinator.infra.llm.gemini.GeminiChatModel;
import com.mc.musiccoordinator.infra.llm.gemini.TextRequest;

public class Coordinator {
    public SongMessage coordinate(String msg){

        msg += ". 노래 1곡만 추천해줘. 추천이유도 알려줘.";

        BaseChatModel model = GeminiChatModel.getInstance();
        BaseRequest request = new TextRequest(msg, new ResponseFormat<SongMessage>(SongMessage.class));

        BaseResponse response = model.invoke(request);

        SongMessage song = response.response(SongMessage.class);

        QRCodeGenerator qrcode = new QRCodeGenerator();
        qrcode.generate(song);
        return song;
    }
}
