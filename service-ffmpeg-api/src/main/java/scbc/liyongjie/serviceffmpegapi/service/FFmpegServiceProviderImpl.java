package scbc.liyongjie.serviceffmpegapi.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scbc.liyongjie.serviceffmpegapi.rpc.*;
import scbc.liyongjie.serviceffmpegapi.util.ResultUtils;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/11
 */
@GrpcService
public class FFmpegServiceProviderImpl extends FFmpegServiceGrpc.FFmpegServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(FFmpegServiceProviderImpl.class);

    @Resource
    private CommandExecuteService commandExecuteService;

    /**
     *  生成缩略图
     * @param request   request {originPath,targetPath}
     * @param responseObserver  response
     */
    @Override
    public void ffmpegBuildThumbnailService(FFmpegBuildThumbnailServiceRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        String targetPath = request.getTargetPath();
        log.info("ffmpegBuildThumbnailService----有新来的Grpc调用------{}------{}",originPath,targetPath);

        commandExecuteService.ffmpegBuildThumbnail(originPath,targetPath);

        responseObserver.onNext(ResultUtils
                .getSuccessResultResponse("ok"));
        responseObserver.onCompleted();
        log.info("ffmpegBuildThumbnailService  onCompleted");
    }

    /**
     * 计算时长
     * @param request request
     * @param responseObserver responseObserver
     */
    @Override
    public void ffmpegCalculateDuration(FFmpegCalculateDurationRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        log.info("ffmpegCalculateDuration----有新来的Grpc调用------{}",originPath);

        String duration = commandExecuteService.ffmpegCalculateDuration(originPath);

        responseObserver.onNext(ResultUtils
                .getSuccessResultResponse(duration));
        responseObserver.onCompleted();
        log.info("ffmpegCalculateDuration  onCompleted");
    }
}
