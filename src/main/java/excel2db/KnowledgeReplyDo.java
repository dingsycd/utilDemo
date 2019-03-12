package excel2db;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by bin on 2017/7/4.
 */
@Data
public class KnowledgeReplyDo {
    private String tenantId;
    private Integer id;
    private String words;
    private String ownerId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer pid;
    private String category;
    private String resource;
    private Integer flag;
}
