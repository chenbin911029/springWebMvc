package com.springmvc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenbin on 2017\11\14 0014.
 */
@Controller
@RequestMapping("/angular")
public class AngularJsController {
    @RequestMapping(value = "/table")
    public String table() {
        return "angular/table";
    }

    @RequestMapping(value="/tableJson", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject testJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("Name","菜鸟教程");
        jsonObject1.put("Country","中国");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Name","Google");
        jsonObject2.put("Country","美国");

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("Name","Facebook");
        jsonObject3.put("Country","英国");

        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);

        jsonObject.put("records",jsonArray);
        return jsonObject;
    }
}
