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
 * Specifies a file upload destination within an Azure blob storage container.
 */
public class OutputFileBlobContainerDestination {
    /**
     * The destination blob or virtual directory within the Azure Storage
     * container.
     * If filePattern refers to a specific file (i.e. contains no wildcards),
     * then path is the name of the blob to which to upload that file. If
     * filePattern contains one or more wildcards (and therefore may match
     * multiple files), then path is the name of the blob virtual directory
     * (which is prepended to each blob name) to which to upload the file(s).
     * If omitted, file(s) are uploaded to the root of the container with a
     * blob name matching their file name.
     */
    @JsonProperty(value = "path")
    private String path;

    /**
     * The URL of the container within Azure Blob Storage to which to upload
     * the file(s).
     * The URL must include a Shared Access Signature (SAS) granting write
     * permissions to the container.
     */
    @JsonProperty(value = "containerUrl", required = true)
    private String containerUrl;

    /**
     * Get the path value.
     *
     * @return the path value
     */
    public String path() {
        return this.path;
    }

    /**
     * Set the path value.
     *
     * @param path the path value to set
     * @return the OutputFileBlobContainerDestination object itself.
     */
    public OutputFileBlobContainerDestination withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the containerUrl value.
     *
     * @return the containerUrl value
     */
    public String containerUrl() {
        return this.containerUrl;
    }

    /**
     * Set the containerUrl value.
     *
     * @param containerUrl the containerUrl value to set
     * @return the OutputFileBlobContainerDestination object itself.
     */
    public OutputFileBlobContainerDestination withContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
        return this;
    }

}
