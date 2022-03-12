package cn.scbc.servicevideouploadapi.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest;
import scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest;
import scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest;
import scbc.liyongjie.serviceffmpegapi.rpc.FFmpegServiceGrpc;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/11
 */

@Component
public class FFmpegServiceConsumerGrpc {

    @GrpcClient("consumer-grpc-client")
    private FFmpegServiceGrpc.FFmpegServiceBlockingStub fFmpegServiceStub;

    private static final String ORIGIN_PATH = "/Users/lemt/Desktop/电影Video/video.mp4";
    private static final String TARGET_PATH = "/Users/lemt/Desktop/电影Video/videoDASH/video.mpd";
    private static final Integer SECOND_TIME = 520;

    public String buildDash(){

        return fFmpegServiceStub
                .ffmpegBuildDASHService(FFmpegBuildDASHServiceRequest
                .newBuilder()
                .setOriginPath(ORIGIN_PATH)
                .setTargetPath(TARGET_PATH)
                .build())
                .toString();
    }

    public String buildThumbnail(){
        return fFmpegServiceStub
                .ffmpegBuildThumbnailService(FFmpegBuildThumbnailServiceRequest
                        .newBuilder()
                        .setOriginPath(ORIGIN_PATH)
                        .setTargetPath(TARGET_PATH)
                        .setTime(SECOND_TIME)
                        .build())
                .toString();
    }

    public String calculateDuration(){
        return fFmpegServiceStub
                .ffmpegCalculateDuration(FFmpegCalculateDurationRequest
                        .newBuilder()
                        .setOriginPath(ORIGIN_PATH)
                        .build())
                .toString();
    }

}
