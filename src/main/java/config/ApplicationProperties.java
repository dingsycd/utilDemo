package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yangkangwei on 2020/01/15
 */
@Component
public class ApplicationProperties {


    @Value("${max_retry_times:3}")
    private Integer maxRetryTimes;

    public Integer getMaxRetryTimes() {
        return maxRetryTimes;
    }

    // -----ISTP-接口-----Start-----
    @Value("${istp_trading_day_service_id:/inner/market/tradingDay}")
    private String istpTradingDayServiceId;

    public String getIstpTradingDayServiceId() {
        return istpTradingDayServiceId;
    }

    @Value("${istp_encrypt_service_id:/inner/util/common/encrypt}")
    private String istpEncryptServiceId;

    public String getIstpEncryptServiceId() {
        return istpEncryptServiceId;
    }

    @Value("${istp_decrypt_service_id:/inner/util/common/decrypt}")
    private String istpDecryptServiceId;

    public String getIstpDecryptServiceId() {
        return istpDecryptServiceId;
    }

    @Value("${istp_find_cust_list_service_id:/inner/advisor/ra/userCenter/findCustList}")
    private String istpFindCustListServiceId;

    public String getIstpFindCustListServiceId() {
        return istpFindCustListServiceId;
    }

    @Value("${istp_find_cust_list_by_custids_service_id:/inner/advisor/ra/userCenter/findCustListByCustIds}")
    private String istpFindCustListByCustIdsServiceId;

    public String getIstpFindCustListByCustIdsServiceId() {
        return istpFindCustListByCustIdsServiceId;
    }

    @Value("${istp_find_sign_user_info_service_id:/inner/advisor/ra/userCenter/findSignUserInfo}")
    private String istpFindSignUserInfoServiceId;

    public String getIstpFindSignUserInfoServiceId() {
        return istpFindSignUserInfoServiceId;
    }

    @Value("${istp_find_sign_user_info_by_ids_service_id:/inner/advisor/ra/userCenter/findSignUserInfoByIds}")
    private String istpFindSignUserInfoByIdsServiceId;

    public String getIstpFindSignUserInfoByIdsServiceId() {
        return istpFindSignUserInfoByIdsServiceId;
    }

    // -----ISTP-信息加密解密-天安加密-密钥-SM4-ECB-----
    @Value("${encrypt_decrypt_key_sm4_ecb}")
    private String encryptDecryptKeySm4Ecb;

    public String getEncryptDecryptKeySm4Ecb() {
        return encryptDecryptKeySm4Ecb;
    }

    // -----job-----
    @Value("${msg_send_user_page_count}")
    private Integer msgSendUserPageCount;

    public Integer getMsgSendUserPageCount() {
        return msgSendUserPageCount;
    }

    @Value("${timer_msg_produce_factory_job_enable}")
    private Boolean timerMsgProduceFactoryJobEnable;

    public Boolean getTimerMsgProduceFactoryJobEnable() {
        return timerMsgProduceFactoryJobEnable;
    }

    @Value("${timer_msg_produce_factory_job_interval_time}")
    private Long timerMsgProduceFactoryJobIntervalTime;

    public Long getTimerMsgProduceFactoryJobIntervalTime() {
        return timerMsgProduceFactoryJobIntervalTime;
    }

    @Value("${real_time_msg_produce_job_enable}")
    private Boolean realTimeMsgProduceJobEnable;

    public Boolean getRealTimeMsgProduceJobEnable() {
        return realTimeMsgProduceJobEnable;
    }

    @Value("${calc_job_enable}")
    private Boolean calcJobEnable;

    public Boolean getCalcJobEnable() {
        return calcJobEnable;
    }

    @Value("${calc_job_interval_time}")
    private Long calcJobIntervalTime;

    public Long getCalcJobIntervalTime() {
        return calcJobIntervalTime;
    }

    @Value("${dxb_calc_job_enable}")
    private Boolean dxbCalcJobEnable;

    public Boolean getDxbCalcJobEnable() {
        return dxbCalcJobEnable;
    }

    // -----realtime-message-template-----
    @Value("${handle_kafka_msg_type_yjpt_enable}")
    private Boolean handleKafkaMsgTypeYjptEnable;

    public Boolean getHandleKafkaMsgTypeYjptEnable() {
        return handleKafkaMsgTypeYjptEnable;
    }

    @Value("${handle_kafka_msg_type_dt_enable}")
    private Boolean handleKafkaMsgTypeDtEnable;

    public Boolean getHandleKafkaMsgTypeDtEnable() {
        return handleKafkaMsgTypeDtEnable;
    }

    // -----kafka-----
    @Value("${kafka.subscribe:csc-advisor-ra-msg}")
    private String kafkaSubscribe;

    public String getKafkaSubscribe() {
        return kafkaSubscribe;
    }

    // -----BUSI-APP-WX-----
    @Value("${provider_id}")
    private String providerId;

    public String getProviderId() {
        return providerId;
    }

    @Value("${auditor_id}")
    private String auditorId;

    public String getAuditorId() {
        return auditorId;
    }

    @Value("${topic_id}")
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    @Value("${priority}")
    private Integer priority;

    public Integer getPriority() {
        return priority;
    }

    // -----BUSI-SMS-----
    @Value("${user_id}")
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Value("${service_code}")
    private String serviceCode;

    public String getServiceCode() {
        return serviceCode;
    }

    @Value("${sign}")
    private String sign;

    public String getSign() {
        return sign;
    }

    @Value("${transaction_id}")
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    // -----杜伟的配置-----Start-----
    @Value("${push_msg_job_enable}")
    private Boolean pushMsgJobEnable;

    public Boolean getPushMsgJobEnable() {
        return pushMsgJobEnable;
    }

    @Value("${push_msg_job_interval_time}")
    private Long pushMsgJobIntervalTime;

    public Long getPushMsgJobIntervalTime() {
        return pushMsgJobIntervalTime;
    }

    @Value("${push_msg_report_job_enable}")
    private Boolean pushMsgReportJobEnable;

    public Boolean getPushMsgReportJobEnable() {
        return pushMsgReportJobEnable;
    }

    @Value("${push_msg_report_job_interval_time}")
    private Long pushMsgReportJobIntervalTime;

    public Long getPushMsgReportJobIntervalTime() {
        return pushMsgReportJobIntervalTime;
    }

    @Value("${push_msg_report_job_page_count}")
    private Integer pushMsgReportJobPageCount;

    public Integer getPushMsgReportJobPageCount() {
        return pushMsgReportJobPageCount;
    }

    @Value("${push_url_wx_ip}")
    private String pushUrlWxIp;

    public String getPushUrlWxIp() {
        return pushUrlWxIp;
    }

    @Value("${push_url_wx_url}")
    private String pushUrlWxUrl;

    public String getPushUrlWxUrl() {
        return pushUrlWxUrl;
    }

    @Value("${push_url_dx_ip}")
    private String pushUrlDxIp;

    public String getPushUrlDxIp() {
        return pushUrlDxIp;
    }

    @Value("${push_url_dx_url}")
    private String pushUrlDxUrl;

    public String getPushUrlDxUrl() {
        return pushUrlDxUrl;
    }

    @Value("${push_url_report_url}")
    private String pushUrlReportUrl;

    public String getPushUrlReportUrl() {
        return pushUrlReportUrl;
    }
    // -----杜伟的配置-----End-----

}
