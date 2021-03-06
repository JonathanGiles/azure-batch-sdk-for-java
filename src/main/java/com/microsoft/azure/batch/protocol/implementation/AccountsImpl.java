/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.implementation;

import retrofit2.Retrofit;
import com.microsoft.azure.batch.protocol.Accounts;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.batch.protocol.models.AccountListNodeAgentSkusHeaders;
import com.microsoft.azure.batch.protocol.models.AccountListNodeAgentSkusNextOptions;
import com.microsoft.azure.batch.protocol.models.AccountListNodeAgentSkusOptions;
import com.microsoft.azure.batch.protocol.models.BatchErrorException;
import com.microsoft.azure.batch.protocol.models.NodeAgentSku;
import com.microsoft.azure.batch.protocol.models.PageImpl;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.DateTimeRfc1123;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponseWithHeaders;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import okhttp3.ResponseBody;
import org.joda.time.DateTime;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Accounts.
 */
public class AccountsImpl implements Accounts {
    /** The Retrofit service to perform REST calls. */
    private AccountsService service;
    /** The service client containing this operation class. */
    private BatchServiceClientImpl client;

    /**
     * Initializes an instance of AccountsImpl.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public AccountsImpl(Retrofit retrofit, BatchServiceClientImpl client) {
        this.service = retrofit.create(AccountsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Accounts to be
     * used by Retrofit to perform actually REST calls.
     */
    interface AccountsService {
        @Headers({ "Content-Type: application/json; odata=minimalmetadata; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.batch.protocol.Accounts listNodeAgentSkus" })
        @GET("nodeagentskus")
        Observable<Response<ResponseBody>> listNodeAgentSkus(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("$filter") String filter, @Query("maxresults") Integer maxResults, @Query("timeout") Integer timeout, @Header("client-request-id") UUID clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; odata=minimalmetadata; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.batch.protocol.Accounts listNodeAgentSkusNext" })
        @GET
        Observable<Response<ResponseBody>> listNodeAgentSkusNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("client-request-id") UUID clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws BatchErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;NodeAgentSku&gt; object if successful.
     */
    public PagedList<NodeAgentSku> listNodeAgentSkus() {
        ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response = listNodeAgentSkusSinglePageAsync().toBlocking().single();
        return new PagedList<NodeAgentSku>(response.body()) {
            @Override
            public Page<NodeAgentSku> nextPage(String nextPageLink) {
                return listNodeAgentSkusNextSinglePageAsync(nextPageLink, null).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<NodeAgentSku>> listNodeAgentSkusAsync(final ListOperationCallback<NodeAgentSku> serviceCallback) {
        return AzureServiceFuture.fromHeaderPageResponse(
            listNodeAgentSkusSinglePageAsync(),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(String nextPageLink) {
                    return listNodeAgentSkusNextSinglePageAsync(nextPageLink, null);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<Page<NodeAgentSku>> listNodeAgentSkusAsync() {
        return listNodeAgentSkusWithServiceResponseAsync()
            .map(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Page<NodeAgentSku>>() {
                @Override
                public Page<NodeAgentSku> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusWithServiceResponseAsync() {
        return listNodeAgentSkusSinglePageAsync()
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink, null));
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;NodeAgentSku&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusSinglePageAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions = null;
        String filter = null;
        Integer maxResults = null;
        Integer timeout = null;
        UUID clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTime ocpDate = null;
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.listNodeAgentSkus(this.client.apiVersion(), this.client.acceptLanguage(), filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> result = listNodeAgentSkusDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>(result.body(), result.headers(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param accountListNodeAgentSkusOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws BatchErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;NodeAgentSku&gt; object if successful.
     */
    public PagedList<NodeAgentSku> listNodeAgentSkus(final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions) {
        ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response = listNodeAgentSkusSinglePageAsync(accountListNodeAgentSkusOptions).toBlocking().single();
        return new PagedList<NodeAgentSku>(response.body()) {
            @Override
            public Page<NodeAgentSku> nextPage(String nextPageLink) {
                AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions = null;
                if (accountListNodeAgentSkusOptions != null) {
                    accountListNodeAgentSkusNextOptions = new AccountListNodeAgentSkusNextOptions();
                    accountListNodeAgentSkusNextOptions.withClientRequestId(accountListNodeAgentSkusOptions.clientRequestId());
                    accountListNodeAgentSkusNextOptions.withReturnClientRequestId(accountListNodeAgentSkusOptions.returnClientRequestId());
                    accountListNodeAgentSkusNextOptions.withOcpDate(accountListNodeAgentSkusOptions.ocpDate());
                }
                return listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param accountListNodeAgentSkusOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<NodeAgentSku>> listNodeAgentSkusAsync(final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions, final ListOperationCallback<NodeAgentSku> serviceCallback) {
        return AzureServiceFuture.fromHeaderPageResponse(
            listNodeAgentSkusSinglePageAsync(accountListNodeAgentSkusOptions),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(String nextPageLink) {
                    AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions = null;
                    if (accountListNodeAgentSkusOptions != null) {
                        accountListNodeAgentSkusNextOptions = new AccountListNodeAgentSkusNextOptions();
                        accountListNodeAgentSkusNextOptions.withClientRequestId(accountListNodeAgentSkusOptions.clientRequestId());
                        accountListNodeAgentSkusNextOptions.withReturnClientRequestId(accountListNodeAgentSkusOptions.returnClientRequestId());
                        accountListNodeAgentSkusNextOptions.withOcpDate(accountListNodeAgentSkusOptions.ocpDate());
                    }
                    return listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param accountListNodeAgentSkusOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<Page<NodeAgentSku>> listNodeAgentSkusAsync(final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions) {
        return listNodeAgentSkusWithServiceResponseAsync(accountListNodeAgentSkusOptions)
            .map(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Page<NodeAgentSku>>() {
                @Override
                public Page<NodeAgentSku> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param accountListNodeAgentSkusOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusWithServiceResponseAsync(final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions) {
        return listNodeAgentSkusSinglePageAsync(accountListNodeAgentSkusOptions)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions = null;
                    if (accountListNodeAgentSkusOptions != null) {
                        accountListNodeAgentSkusNextOptions = new AccountListNodeAgentSkusNextOptions();
                        accountListNodeAgentSkusNextOptions.withClientRequestId(accountListNodeAgentSkusOptions.clientRequestId());
                        accountListNodeAgentSkusNextOptions.withReturnClientRequestId(accountListNodeAgentSkusOptions.returnClientRequestId());
                        accountListNodeAgentSkusNextOptions.withOcpDate(accountListNodeAgentSkusOptions.ocpDate());
                    }
                    return Observable.just(page).concatWith(listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink, accountListNodeAgentSkusNextOptions));
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
    ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> * @param accountListNodeAgentSkusOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;NodeAgentSku&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusSinglePageAsync(final AccountListNodeAgentSkusOptions accountListNodeAgentSkusOptions) {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(accountListNodeAgentSkusOptions);
        String filter = null;
        if (accountListNodeAgentSkusOptions != null) {
            filter = accountListNodeAgentSkusOptions.filter();
        }
        Integer maxResults = null;
        if (accountListNodeAgentSkusOptions != null) {
            maxResults = accountListNodeAgentSkusOptions.maxResults();
        }
        Integer timeout = null;
        if (accountListNodeAgentSkusOptions != null) {
            timeout = accountListNodeAgentSkusOptions.timeout();
        }
        UUID clientRequestId = null;
        if (accountListNodeAgentSkusOptions != null) {
            clientRequestId = accountListNodeAgentSkusOptions.clientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (accountListNodeAgentSkusOptions != null) {
            returnClientRequestId = accountListNodeAgentSkusOptions.returnClientRequestId();
        }
        DateTime ocpDate = null;
        if (accountListNodeAgentSkusOptions != null) {
            ocpDate = accountListNodeAgentSkusOptions.ocpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.listNodeAgentSkus(this.client.apiVersion(), this.client.acceptLanguage(), filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> result = listNodeAgentSkusDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>(result.body(), result.headers(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> listNodeAgentSkusDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<NodeAgentSku>, BatchErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<NodeAgentSku>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, AccountListNodeAgentSkusHeaders.class);
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws BatchErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;NodeAgentSku&gt; object if successful.
     */
    public PagedList<NodeAgentSku> listNodeAgentSkusNext(final String nextPageLink) {
        ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response = listNodeAgentSkusNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<NodeAgentSku>(response.body()) {
            @Override
            public Page<NodeAgentSku> nextPage(String nextPageLink) {
                return listNodeAgentSkusNextSinglePageAsync(nextPageLink, null).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<NodeAgentSku>> listNodeAgentSkusNextAsync(final String nextPageLink, final ServiceFuture<List<NodeAgentSku>> serviceFuture, final ListOperationCallback<NodeAgentSku> serviceCallback) {
        return AzureServiceFuture.fromHeaderPageResponse(
            listNodeAgentSkusNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(String nextPageLink) {
                    return listNodeAgentSkusNextSinglePageAsync(nextPageLink, null);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<Page<NodeAgentSku>> listNodeAgentSkusNextAsync(final String nextPageLink) {
        return listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Page<NodeAgentSku>>() {
                @Override
                public Page<NodeAgentSku> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusNextWithServiceResponseAsync(final String nextPageLink) {
        return listNodeAgentSkusNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink, null));
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;NodeAgentSku&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions = null;
        UUID clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTime ocpDate = null;
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNodeAgentSkusNext(nextUrl, this.client.acceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> result = listNodeAgentSkusNextDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>(result.body(), result.headers(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param accountListNodeAgentSkusNextOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws BatchErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;NodeAgentSku&gt; object if successful.
     */
    public PagedList<NodeAgentSku> listNodeAgentSkusNext(final String nextPageLink, final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions) {
        ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response = listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions).toBlocking().single();
        return new PagedList<NodeAgentSku>(response.body()) {
            @Override
            public Page<NodeAgentSku> nextPage(String nextPageLink) {
                return listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param accountListNodeAgentSkusNextOptions Additional parameters for the operation
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<NodeAgentSku>> listNodeAgentSkusNextAsync(final String nextPageLink, final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions, final ServiceFuture<List<NodeAgentSku>> serviceFuture, final ListOperationCallback<NodeAgentSku> serviceCallback) {
        return AzureServiceFuture.fromHeaderPageResponse(
            listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(String nextPageLink) {
                    return listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param accountListNodeAgentSkusNextOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<Page<NodeAgentSku>> listNodeAgentSkusNextAsync(final String nextPageLink, final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions) {
        return listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink, accountListNodeAgentSkusNextOptions)
            .map(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Page<NodeAgentSku>>() {
                @Override
                public Page<NodeAgentSku> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param accountListNodeAgentSkusNextOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;NodeAgentSku&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusNextWithServiceResponseAsync(final String nextPageLink, final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions) {
        return listNodeAgentSkusNextSinglePageAsync(nextPageLink, accountListNodeAgentSkusNextOptions)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNodeAgentSkusNextWithServiceResponseAsync(nextPageLink, accountListNodeAgentSkusNextOptions));
                }
            });
    }

    /**
     * Lists all node agent SKUs supported by the Azure Batch service.
     *
    ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> * @param nextPageLink The NextLink from the previous successful call to List operation.
    ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> * @param accountListNodeAgentSkusNextOptions Additional parameters for the operation
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;NodeAgentSku&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> listNodeAgentSkusNextSinglePageAsync(final String nextPageLink, final AccountListNodeAgentSkusNextOptions accountListNodeAgentSkusNextOptions) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Validator.validate(accountListNodeAgentSkusNextOptions);
        UUID clientRequestId = null;
        if (accountListNodeAgentSkusNextOptions != null) {
            clientRequestId = accountListNodeAgentSkusNextOptions.clientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (accountListNodeAgentSkusNextOptions != null) {
            returnClientRequestId = accountListNodeAgentSkusNextOptions.returnClientRequestId();
        }
        DateTime ocpDate = null;
        if (accountListNodeAgentSkusNextOptions != null) {
            ocpDate = accountListNodeAgentSkusNextOptions.ocpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNodeAgentSkusNext(nextUrl, this.client.acceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> result = listNodeAgentSkusNextDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<NodeAgentSku>, AccountListNodeAgentSkusHeaders>(result.body(), result.headers(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<PageImpl<NodeAgentSku>, AccountListNodeAgentSkusHeaders> listNodeAgentSkusNextDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<NodeAgentSku>, BatchErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<NodeAgentSku>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, AccountListNodeAgentSkusHeaders.class);
    }

}
