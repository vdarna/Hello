package com.example.department.entity;

import java.util.ArrayList;
import java.util.List;

class Emp {

    public String getSample() {

        String env = "prod";
        List<String> list = getFileList(env);
        if (list != null) {
            return "Success";
        } else {
            return "Failure";
        }

    }

    public static List<String> getFileList(String env) {
        List<String> files = new ArrayList<>();
        if (env.equals("prod")) {
            files.add("app_prod.yml");
        } else {
            files.add("app.yml");
        }

        return files;
    }
}

