/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Options for disabling scheduling on a compute node.
 */
public class NodeDisableSchedulingParameter {
    /**
     * What to do with currently running tasks when disabling task scheduling
     * on the compute node.
     * Values are:
     *
     * requeue - Terminate running task processes and requeue the tasks. The
     * tasks may run again on other compute nodes, or when task scheduling is
     * re-enabled on this node. Enter offline state as soon as tasks have been
     * terminated.
     * terminate - Terminate running tasks. The tasks will not run again. Enter
     * offline state as soon as tasks have been terminated.
     * taskcompletion - Allow currently running tasks to complete. Schedule no
     * new tasks while waiting. Enter offline state when all tasks have
     * completed.
     *
     * The default value is requeue. Possible values include: 'requeue',
     * 'terminate', 'taskCompletion'.
     */
    @JsonProperty(value = "nodeDisableSchedulingOption")
    private DisableComputeNodeSchedulingOption nodeDisableSchedulingOption;

    /**
     * Get the nodeDisableSchedulingOption value.
     *
     * @return the nodeDisableSchedulingOption value
     */
    public DisableComputeNodeSchedulingOption nodeDisableSchedulingOption() {
        return this.nodeDisableSchedulingOption;
    }

    /**
     * Set the nodeDisableSchedulingOption value.
     *
     * @param nodeDisableSchedulingOption the nodeDisableSchedulingOption value to set
     * @return the NodeDisableSchedulingParameter object itself.
     */
    public NodeDisableSchedulingParameter withNodeDisableSchedulingOption(DisableComputeNodeSchedulingOption nodeDisableSchedulingOption) {
        this.nodeDisableSchedulingOption = nodeDisableSchedulingOption;
        return this;
    }

}
