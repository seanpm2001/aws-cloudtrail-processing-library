/*******************************************************************************
 * Copyright 2010-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 ******************************************************************************/

package com.amazonaws.services.cloudtrail.processinglibrary.model;

import com.amazonaws.services.cloudtrail.processinglibrary.model.internal.CloudTrailDataStore;
import com.amazonaws.services.cloudtrail.processinglibrary.model.internal.CloudTrailEventField;
import com.amazonaws.services.cloudtrail.processinglibrary.model.internal.InsightDetails;
import com.amazonaws.services.cloudtrail.processinglibrary.model.internal.Resource;
import com.amazonaws.services.cloudtrail.processinglibrary.model.internal.UserIdentity;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Contains information about requests for resources in your AWS account.
 * <p>
 * Information provided includes what services were accessed, what action was performed, and any parameters for the
 * action. The request also provides information about who made the request.
 *
 * @see <a href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/event_reference_top_level.html">CloudTrail Event Reference</a>
 */
public class CloudTrailEventData extends CloudTrailDataStore {
    /**
     * Get the event version.
     *
     * @return The version of the log event format. The current version is 1.02.
     */
    public String getEventVersion() {
        return (String) get(CloudTrailEventField.eventVersion.name());
    }

    /**
     * Get the UserIdentity object held by this instance.
     *
     * @see <a href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/event_reference_user_identity.html">userIdentity Element</a>
     * @return Information about the user that made a request.
     */
    public UserIdentity getUserIdentity() {
        return (UserIdentity) get(CloudTrailEventField.userIdentity.name());
    }

    /**
     * Get the event timestamp for this event.
     *
     * @return The date and time the request was made, in coordinated universal time (UTC).
     */
    public Date getEventTime() {
        return (Date) get(CloudTrailEventField.eventTime.name());
    }

    /**
     * Get the event name for this event.
     *
     * @see <a href="http://docs.aws.amazon.com/awscloudtrail/latest/APIReference/API_Operations.html">AWS CloudTrail Actions</a>
     * @return The event name, an AWS CloudTrail action as listed in the API Reference.
     */
    public String getEventName() {
        return (String) get(CloudTrailEventField.eventName.name());
    }


    /**
     * Get the event source for this event.
     *
     * @return The service that the request was made to. For example, a call to Amazon EC2 is listed in the eventSource
     *     field as ec2.amazonaws.com.
     */
    public String getEventSource() {
        return (String) get(CloudTrailEventField.eventSource.name());
    }

    /**
     * Get the AWS region for this event.
     *
     * @return The AWS region that the request was made to.
     */
    public String getAwsRegion() {
        return (String) get(CloudTrailEventField.awsRegion.name());
    }

    /**
     * Get the source IP address for this event.
     * <p>
     * For actions that originate from the service console, the address reported is for the underlying customer
     * resource, not the console web server. For services in AWS, only the DNS name is displayed.
     * </p>
     * @return The apparent IP address that the request was made from.
     */
    public String getSourceIPAddress() {
        return (String) get(CloudTrailEventField.sourceIPAddress.name());
    }

    /**
     * Get the event user agent for this event.
     *
     * @return The agent through which the request was made, such as the AWS Management Console or an AWS SDK.
     */
    public String getUserAgent() {
        return (String) get(CloudTrailEventField.userAgent.name());
    }

    /**
     * Get the request ID.
     *
     * @return An identifier generated by the service being called to uniquely identify
     *    the request.
     */
    public String getRequestId() {
        return (String) get(CloudTrailEventField.requestID.name());
    }

    /**
     * Get the API call error code.
     *
     * @return The AWS service error if the request returns an error, or <code>null</code> if no error was returned.
     */
    public String getErrorCode() {
        return (String) get(CloudTrailEventField.errorCode.name());
    }

    /**
     * Get API call error message.
     * <p>
     * This includes messages for authorization failures. For such messages, CloudTrail captures the message logged by
     * the service in its exception handling.
     * </p>
     * @return If the request returns an error, the description of the error, or <code>null</code> if there was no
     *     error.
     */
    public String getErrorMessage() {
        return (String) get(CloudTrailEventField.errorMessage.name());
    }

    /**
     * Get API call request parameters.
     * <p>
     * API Request parameters are specific to both the AWS service and the API action that is being called. Refer to the
     * API reference for the service identified in the request for more details about the parameters.
     * </p>
     * @return The parameters, if any, that were sent with the request.
     */
    public String getRequestParameters() {
        return (String) get(CloudTrailEventField.requestParameters.name());
    }

    /**
     * Get API call response elements.
     * <p>
     * If an action does not change state (for example, a request to <code>get</code> or <code>list</code> objects),
     * this element is omitted. Response elements such as request parameters are documented in the API Reference
     * documentation for the AWS service identified in the response.
     * </p>
     * @return The response element for actions that make changes (such as the <code>create</code>, <code>update</code>,
     *     or <code>delete</code> actions).
     */
    public String getResponseElements() {
        return (String) get(CloudTrailEventField.responseElements.name());
    }


    /**
     * Get aws service event details
     * <p>
     * This field will only be visible to awsServiceEvent type, it indicates what trigger the event and what the result
     * of this event.
     * </p>
     * @return The service event detail for an awsServiceEvent type event
     */
    public String getServiceEventDetails() {
        return (String) get(CloudTrailEventField.serviceEventDetails.name());
    }

    /**
     * Get additional API data.
     *
     * @return Additional API call data set by AWS services.
     */
    public String getAdditionalEventData() {
        return (String) get(CloudTrailEventField.additionalEventData.name());
    }

    /**
     * Get the event ID.
     * <p>
     * You can use this value to identify a single event. For example, you can use the ID as a primary key to retrieve
     * log data from a searchable database.
     * </p>
     * @return A GUID generated by CloudTrail to uniquely identify each event.
     */
    public UUID getEventId() {
        return (UUID) get(CloudTrailEventField.eventID.name());
    }

    /**
     * Check whether the operation is read-only.
     *
     * @return <code>true</code> if the operation identified in the log is read-only.
     */
    public Boolean isReadOnly() {
        return (Boolean) get(CloudTrailEventField.readOnly.name());
    }

    /**
     * Check whether the event is a management event.
     * @return <code>true</code> if the event identified in the log is a management event.
     */
    public Boolean isManagementEvent() {
        return (Boolean) get(CloudTrailEventField.managementEvent.name());
    }
    /**
     * Get the resources used in the operation.
     *
     * @return A list of resources used in this operation.
     */
    @SuppressWarnings("unchecked")
    public List<Resource> getResources() {
        return (List<Resource>) get(CloudTrailEventField.resources.name());
    }

    /**
     * Get the AWS account ID from UserIdentity.
     * <p>
     * If the request was made using temporary security credentials, this is the account that owns the IAM user or role
     * that was used to obtain credentials.
     * </p>
     * @return The account that owns the entity that granted permissions for the request.
     */
    public String getAccountId() {
        return (String) get(CloudTrailEventField.accountId.name());
    }

    /**
     * Get the event category.
     *
     * @return Identifies the category of CloudTrail event.
     */
    public String getEventCategory() {
        return (String) get(CloudTrailEventField.eventCategory.name());
    }

    /**
     * Get the event type.
     *
     * @return Identifies the type of event that generated the event.
     */
    public String getEventType() {
        return (String) get(CloudTrailEventField.eventType.name());
    }

    /**
     * Get the API version.
     *
     * @return the API version associated with the AWS API call's eventType value.
     */
    public String getApiVersion() {
        return (String) get(CloudTrailEventField.apiVersion.name());
    }

    /**
     * Get the recipient account ID
     *
     * @return the account ID that received this event. This will be the same as the User Identity Element's accountId
     *     value.
     */
    public String getRecipientAccountId() {
        return (String) get(CloudTrailEventField.recipientAccountId.name());
    }

    /**
     * Get the shared event ID
     *
     * @return When recipientAccountList has size greater than 1, then sharedEventID is generated
     *      to indicate multiple CloudTrail events originate from a single service event.
     */
    public String getSharedEventId() {
        return (String) get(CloudTrailEventField.sharedEventID.name());
    }

    /**
     * Get the annotation
     *
     * @return User provided annotation tagging delivered by CloudTrail.
     */
    public String getAnnotation() {
        return (String) get(CloudTrailEventField.annotation.name());
    }

    /**
     * Get the vpc endpoint ID
     *
     * @return The VPC endpoint in which requests were made from a VPC to another AWS service, such as Amazon S3.
     */
    public String getVpcEndpointId() {
        return (String) get(CloudTrailEventField.vpcEndpointId.name());
    }

    /**
     * Get the insight details
     *
     * @return  information about the underlying triggers of an Insights event, such as event source,
     *      statistics, API name, and whether the event is the start or end of the Insights event.
     */
    public InsightDetails getInsightDetails() {
        return (InsightDetails) get(CloudTrailEventField.insightDetails.name());
    }
}
