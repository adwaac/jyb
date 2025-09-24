package com.example.demo.Config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.Properties;
public class SSHConfig {
    private final static String SSH_USER = "root";
    private final static String SSH_PASSWORD = "jianyibao123A";
    private final static String SSH_REMOTE_SERVER = "tiaoban.yibaojiankang.com";
    private final static int SSH_REMOTE_PORT = 22;
    private final static int LOCAL_PORT = 3307;
    private final static int REMOTE_PORT = 3306;
    private final static String MYSQL_REMOTE_SERVER = "rm-bp1boas85teeqr502.mysql.rds.aliyuncs.com";
    private Session session;
    public void connect() throws Exception {
        JSch jsch = new JSch();
        session = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
        session.setPassword(SSH_PASSWORD);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        session.setPortForwardingL(LOCAL_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);
    }
    public void disconnect() {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }
}