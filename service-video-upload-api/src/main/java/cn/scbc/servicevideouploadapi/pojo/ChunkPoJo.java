package cn.scbc.servicevideouploadapi.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/11
 *
 */

public class ChunkPoJo {

    /** file的总大小*/
    private Long size;

    /** 文件的标识id*/
    private String uid;

    /** 任务id，标识当前file是queued里的第几个*/
    private String id;

    /** 文件名*/
    private String name;

    /** 分片数据的md5值*/
    private String md5;

    /** 总分片数量*/
    private Integer chunks;

    /** 当前是第几个分块*/
    private Integer chunk;

    /** chunk对象*/
    private MultipartFile file;

    public long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getChunks() {
        return chunks;
    }

    public void setChunks(Integer chunks) {
        this.chunks = chunks;
    }

    public Integer getChunk() {
        return chunk;
    }

    public void setChunk(Integer chunk) {
        this.chunk = chunk;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ChunkPoJo{" +
                "size=" + size +
                ", uid='" + uid + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", md5='" + md5 + '\'' +
                ", chunks=" + chunks +
                ", chunk=" + chunk +
                ", file=" + file +
                '}';
    }
}
