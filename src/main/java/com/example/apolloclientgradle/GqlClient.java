package com.example.apolloclientgradle;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.queries.GetListTransfersQuery;
import com.schema.type.TransferEntity_filter;
import org.jetbrains.annotations.NotNull;

public class GqlClient {
  private final String serviceUrl;
  private ApolloClient apolloClient;

  public GqlClient(String serviceUrl) {
    this.serviceUrl = serviceUrl;

    this.apolloClient =
      ApolloClient.builder().serverUrl(this.serviceUrl).build();
  }

  public void callQuery() {
    TransferEntity_filter.Builder queryBuilder = TransferEntity_filter.builder();
    queryBuilder.id(
      "0x0166658031779ff39122a79fd34cae42b33ad20eb36a165bfb9e064a2c967d7d_0x270bbcbb91f39b4b438edd0737cf17d993b5d59a_6461036477"
    );
      System.out.println(queryBuilder.build().toString());
    this.apolloClient.query(new GetListTransfersQuery(queryBuilder.build()))
      .enqueue(
        new ApolloCall.Callback<GetListTransfersQuery.Data>() {

          @Override
          public void onResponse(
            @NotNull Response<GetListTransfersQuery.Data> response
          ) {
            System.out.println(response.component2());
          }

          @Override
          public void onFailure(@NotNull ApolloException t) {
                t.printStackTrace();
              System.out.println("loi roi: " + t.getMessage());
          }
        }
      );
  }
}
