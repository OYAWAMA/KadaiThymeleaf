package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping( value= {"/input", "/input/{previous}"})
    public String getForm(@PathVariable(value = "previous", required = false) String previous, Model model) {
        // クエリパラメータから受け取った値をModelに登録
        if (previous != null) {
            model.addAttribute("previous", previous);
        }
        // input.htmlに画面遷移
        return "input";
    }


    @PostMapping("/output")
    public String postForm(@RequestParam("val") String val, Model model) {
        // フォームから送信されてきた値をModelに登録
        model.addAttribute("val", val);
        // output.htmlに画面遷移
        return "output";
    }


}