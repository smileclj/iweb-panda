package com.panda.iweb.test.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huixiangdou on 2016/10/6.
 */
public class SolrJTest {
    private static final String coreUrl = "http://10.1.50.234:8983/solr/core2";
    private static final HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(coreUrl).build();

    @Test
    public void query() {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("q", "solrName:男");
            SolrParams solrParams = new MapSolrParams(params);
            QueryResponse queryResponse = httpSolrClient.query(solrParams);
            System.out.println(queryResponse.getResponse().toString());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void commit() {
        try {
            UpdateResponse updateResponse = httpSolrClient.commit(true, true);
            System.out.println(updateResponse.getResponse().toString());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void add() {
//        SolrInputDocument doc = new SolrInputDocument();
//        httpSolrClient.add()
//    }
}
