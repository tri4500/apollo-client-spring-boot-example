package com.example.apolloclientgradle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApolloClientGradleApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ApolloClientGradleApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println("Server started....");
    GqlClient client = new GqlClient(
      "http://34.87.186.22:8000/subgraphs/name/test/ovl-indexer"
    );
    client.callQuery();
  }
}
