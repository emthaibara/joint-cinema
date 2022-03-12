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

    public String buildDash(String originPath,String targetPath){

        return fFmpegServiceStub
                .ffmpegBuildDASHService(FFmpegBuildDASHServiceRequest
                .newBuilder()
                .setOriginPath(originPath)
                .setTargetPath(targetPath)
                .build())
                .toString();
    }

    public String buildThumbnail(String originPath,String targetPath,Integer time){
        return fFmpegServiceStub
                .ffmpegBuildThumbnailService(FFmpegBuildThumbnailServiceRequest
                        .newBuilder()
                        .setOriginPath(originPath)
                        .setTargetPath(targetPath)
                        .setTime(time)
                        .build())
                .toString();
    }

    public String calculateDuration(String originPath){
        return fFmpegServiceStub
                .ffmpegCalculateDuration(FFmpegCalculateDurationRequest
                        .newBuilder()
                        .setOriginPath(originPath)
                        .build())
                .toString();
    }

}
