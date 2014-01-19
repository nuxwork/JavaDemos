package com.google.gson.demo.java;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Gson1
{
    private static final String TAG = "JavaDemos.Gson1";
    
    public static void main(String[] args)
    {
        System.out.println("\nobject convert to json string.");
        String json = obj2json();
        
        System.out.println("\njson string convert to object.");
        json2obj(json);
        
        System.out.println("\nlist convert to json string.");
        String jsonList = objList2json();
        
        System.out.println("\njson string convert to list.");
        json2objList(jsonList);
        
    }
    
    private static String obj2json()
    {
        Gson gson = new Gson();
        MyType myType = new MyType("Type1", "00001", 1);
        String json = gson.toJson(myType);
        System.out.println(json);
        return json;
    }
    
    private static void json2obj(String json)
    {
        Gson gson = new Gson();
        MyType myType = gson.fromJson(json, MyType.class);
        System.out.println(myType);
    }
    
    private static String objList2json()
    {
        ArrayList<MyType> list = new ArrayList<MyType>();
        for (int i = 0; i != 3; i++)
        {
            MyType type = new MyType("type" + i, "000" + (i+1), i);
            list.add(type);
        }
        
        Gson gson = new Gson();
        String jsonList = gson.toJson(list);
        System.out.println(jsonList);
        return jsonList;
    }
    
    private static void json2objList(String jsonList)
    {
        Gson gson = new Gson();
        ArrayList<MyType> list = gson.fromJson(jsonList, new TypeToken<ArrayList<MyType>>()
        {
        }.getType());
        System.out.println(list.toString());
    }
    
    private static class MyType extends Object
    {
        public String typeName;
        
        public String typeId;
        
        public NativeType nativeType;
        
        public MyType(String typeName, String typeId, int typeSize)
        {
            this.typeName = typeName;
            this.typeId = typeId;
            this.nativeType = new NativeType(typeSize);
        }
        
        @Override
        public String toString()
        {
            return "MyType: [typeName: " + typeName + ", typeId: " + typeId + ", nativeType[typeSize: "
                + nativeType.typeSize + "]" + "]";
        }
    }
    
    private static class NativeType
    {
        public int typeSize;
        
        public NativeType(int typeSize)
        {
            this.typeSize = typeSize;
        }
    }
    
}
