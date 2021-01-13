/*******************************************************************************
 * Copyright 2010-2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.amazonaws.services.cloudtrail.processinglibrary.interfaces;

import com.amazonaws.services.cloudtrail.processinglibrary.AWSCloudTrailProcessingExecutor;
import com.amazonaws.services.cloudtrail.processinglibrary.exceptions.CallbackException;
import com.amazonaws.services.cloudtrail.processinglibrary.model.CloudTrailEvent;

/**
 * Provides a callback method used by an {@link AWSCloudTrailProcessingExecutor} to determine
 * whether or not to process a record.
 * <p>
 * If {@link #filterEvent(CloudTrailEvent)} returns <code>false</code>, then the event is not sent to the
 * {@link EventsProcessor} for further processing.
 * </P>
 */
public interface EventFilter{

    /**
     * A callback method used to filter a {@link CloudTrailEvent} prior to process.
     * <p>
     * For performance, the event object is not a copy; you should only filter the event here, not change its contents.
     * </P>
     * @param event The {@link CloudTrailEvent} to filter.
     * @return <code>true</code> If the event should be processed by the {@link EventsProcessor}.
     * @throws CallbackException If an error occurs while filtering.
     */
    public boolean filterEvent(CloudTrailEvent event) throws CallbackException;

}
