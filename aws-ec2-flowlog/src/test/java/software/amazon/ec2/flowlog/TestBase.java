package software.amazon.ec2.flowlog;

import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.FlowLog;
import software.amazon.awssdk.services.ec2.model.LogDestinationType;
import software.amazon.awssdk.services.ec2.model.TrafficType;

public class TestBase {
    final FlowLog TEST_FLOW_LOG_TO_CWL = FlowLog.builder()
        .flowLogId("fl-0")
        .deliverLogsPermissionArn("arn:aws:iam::0:role/RoleName")
        .logDestination("arn:aws:logs:us-east-1:123456789012:log-group:my-logs")
        .logDestinationType(LogDestinationType.CLOUD_WATCH_LOGS)
        .logGroupName("logGroupName")
        .resourceId("eni-0")
        .trafficType(TrafficType.ALL)
        .build();
    final FlowLog TEST_FLOW_LOG_TO_S3 = FlowLog.builder()
        .flowLogId("fl-0")
        .logDestination("arn:aws:s3:::my-bucket")
        .logDestinationType(LogDestinationType.S3)
        .resourceId("vpc-0")
        .trafficType(TrafficType.ACCEPT)
        .build();

    final AwsServiceException SERVICE_UNAVAILABLE_ERROR = Ec2Exception.builder()
        .awsErrorDetails(AwsErrorDetails.builder()
            .errorCode("ServiceUnavailable")
            .build())
        .message("ServiceUnavailable")
        .build();
}
