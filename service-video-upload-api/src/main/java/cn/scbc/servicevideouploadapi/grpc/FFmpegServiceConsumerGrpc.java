package cn.scbc.servicevideouploadapi.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scbc.liyongjie.serviceffmpegapi.rpc.*;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/11
 */
@Component
public class FFmpegServiceConsumerGrpc {

    private static final Logger log = LoggerFactory.getLogger(FFmpegServiceConsumerGrpc.class);

    private static final String target = "localhost:50051";

    @GrpcClient("ffmpeg-grpc-client")
    private FFmpegServiceGrpc.FFmpegServiceBlockingStub fFmpegServiceStub;

    public void buildThumbnailGrpc(String originPath,String targetPath){
        ResultResponse resultResponse = fFmpegServiceStub.ffmpegBuildThumbnailService(FFmpegBuildThumbnailServiceRequest.newBuilder()
                .setTargetPath(targetPath)
                .setOriginPath(originPath)
                .build());
        log.info("来自-----{}-----正在生成缩略图----目标路径----{}---{}",originPath,target,resultResponse.toString());
    }

    public String calculateDuration(String originPath) {
        ResultResponse resultResponse = fFmpegServiceStub.ffmpegCalculateDuration(FFmpegCalculateDurationRequest.newBuilder().setOriginPath(originPath).build());
        return resultResponse.getResult();
    }

}
