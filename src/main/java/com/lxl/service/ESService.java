package com.lxl.service;

import org.apache.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

import org.springframework.stereotype.Service;

/**
 * Created by xiaolu on 15/6/8.
 */
@Service
public class ESService {
    Logger logger = Logger.getLogger(ESService.class);

    private Node node;
    private Node getNode()
    {
        if(this.node == null) {
            synchronized (ESService.class) {
                if(this.node == null) {
                    this.node = NodeBuilder.nodeBuilder().client(true).node();
                }
            }
        }
        return this.node;
    }

    private Client getClient()
    {
        return this.getNode().client();
    }

    public GetResponse getResponseByIndexTypeId(String index, String type, String Id)
    {
        return this.getClient().prepareGet(index, type, Id)
            .execute()
            .actionGet();
    }
}
