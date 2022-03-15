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
     *      生成dash流
     *      需提供视频源路径
     *      已经待生成dash流的文件夹
     * @param request       request {originPath,targetPath}
     * @param responseObserver  response
     */
    @Override
    public void ffmpegBuildDASHService(FFmpegBuildDASHServiceRequest request, StreamObserver<ResultResponse> responseObserver) {
        String originPath = request.getOriginPath();
        String targetPath = request.getTargetPath();
        log.info("ffmpegBuildDASHService----有新来的Grpc调用------{}------{}",originPath,targetPath);
        ResultResponse.newBuilder().build();
        log.info("origin--{}---targetPath---{}",originPath,targetPath);
        commandExecuteService.ffmpegBuildDASH(originPath,targetPath);

        responseObserver.onNext(ResultUtils
                .getSuccessResultResponse("ok"));
        responseObserver.onCompleted();
        log.info("ffmpegBuildDASHService  onCompleted");
    }

    /**
     *  生成缩略图
     *  首先需要计算视频时长，并传递至该服务
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
}
