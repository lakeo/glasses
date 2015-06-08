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
                    Settings settings = ImmutableSettings.settingsBuilder()
                            .put("http.enabled", "false")
                            .put("transport.tcp.port", "9300-9400")
                            .put("discovery.zen.ping.multicast.enabled", "false")
                            .put("discovery.zen.ping.unicast.hosts", "localhost").build();
                    this.node = NodeBuilder.nodeBuilder().client(true).settings(settings).node();
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
            .setOperationThreaded(false)
            .execute()
            .actionGet();
    }
}
