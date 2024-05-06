package com.example.department.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LoopSecurityIssue {

    public static void main(String args[]){

        List<Provider> providerList = new ArrayList<>();
        providerList.add(new Provider(1,"emp"));
        providerList.add(new Provider(2,"student"));
        providerList.add(new Provider(3,"staff"));

        List<Provider> primaryProviderList = new ArrayList<>();
        primaryProviderList.add(new Provider(1,"IT"));
        primaryProviderList.add(new Provider(2,"student"));
        primaryProviderList.add(new Provider(3,"NON-IT"));
        int loopCount =0;
       // if(Collections.isNotEmpty(providerList))
            loopCount = providerList.size();
        /*for(int i=0;i<loopCount;i++){
            for(int j=0;j<primaryProviderList.size();j++){
                if(providerList.get(i).getType().equals(primaryProviderList.get(j).getType())){
                    providerList.remove(providerList.get(j));
                }

            }
        }
       List<Provider> duplicates = providerList.stream()
                .filter(provider -> primaryProviderList.stream()
                        .anyMatch(primary -> provider.getType().equals(primary.getType())))
                .collect(Collectors.toList());

       providerList.stream()
                .filter(provider -> duplicates.stream()
                        .anyMatch(duplicate -> duplicate.getType().equals(provider.getType())))
                .forEach(providerList::remove);

        providerList = providerList.stream()
                .filter(provider -> primaryProviderList.stream()
                        .noneMatch(primaryProvider -> provider.getType().equals(primaryProvider.getType())))
                .collect(Collectors.toList());*/
        System.out.println(providerList.size());
        int[] counter = {0};
        boolean[] hasFacility = {false};
        String[] value={""};
        providerList.forEach(provider -> {
                    if(provider.getType().equalsIgnoreCase("emp1"))
                        value[0] = "emp1";
                }
                );
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String hostName = InetAddress.getLocalHost().getHostName().split("\\.")[0];
            String fileName = "sample_test_"+timeStamp+"_"+hostName;
            objectMapper.writeValue(new File("folderName",fileName + ".json"),
                    new Provider(1,"IT"));

        }catch (Exception e){

        }



        System.out.println(hasFacility[0]);
    }
}
