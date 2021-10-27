package cn.Hbase.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

public class test1 {

    Configuration conf;
    Connection connection;

    public void buildConnection() {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quoram", "H1");
        conf.set("hbase.zookeeper.property.clientPort", "2181");

        try {
            connection = ConnectionFactory.createConnection(conf);

            Admin admin = connection.getAdmin();
            TableName[] names = admin.listTableNames();

            for (TableName tn : names)
                System.out.println("table name:" + tn.getNameAsString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("test");

        test1 demo = new test1();
        demo.buildConnection();
    }
}