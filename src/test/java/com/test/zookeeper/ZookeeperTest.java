package com.test.zookeeper;

import com.test.BaseTest;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.net.InetAddress;


/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/11/4 下午12:01.
 */
public class ZookeeperTest extends BaseTest {
    public void zooTest() {
        try {
            ZooKeeper zk = new ZooKeeper("", 1, null);
            byte[] localhost = InetAddress.getLocalHost().getAddress();
            zk.create("" + "/leader", localhost, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
