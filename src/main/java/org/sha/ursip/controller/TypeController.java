package org.sha.ursip.controller;

import org.sha.ursip.service.CountNews;
import org.sha.ursip.dao.ArticleLinkDAO;
import org.sha.ursip.dao.ArticlesDAO;
import org.sha.ursip.dao.TypesDAO;
import org.sha.ursip.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/types.htm")
public class TypeController {
    @Autowired
    CountNews countNews;
    @Autowired
    TypesDAO typesDAO;
    @Autowired
    ArticleLinkDAO articleLinkDAO;
    @Autowired
    ArticlesDAO articlesDAO;


    @Autowired
    @Qualifier("typeValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

        @RequestMapping(method = RequestMethod.GET)
        public  String initCombobox(Model model) {
            Type types = new Type();
            model.addAttribute("types", types);
            initModelList(model);
            return "types";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String submitTable(Model model, @Validated Type types, BindingResult result)
                throws UnsupportedEncodingException{
            model.addAttribute("types", types);
            String val = "addSuccess";
            if(result.hasErrors()) {
                initModelList(model);
                val = "types";
            } else {
                System.out.println(types.getTypeName());
                if (types.getTypeName().contains("Ð\u009DÐ¾Ð²Ð¾Ñ\u0081Ñ\u0082Ð")) {


                    model.addAttribute("listTypes", countNews.countNewsList(1));
                }
                else if (types.getTypeName().contains("Ð¡Ð¾Ð±Ñ\u008BÑ\u0082Ð¸Ñ\u008F")) {


                    model.addAttribute("listTypes", countNews.countNewsList(2));
                }
                else if (types.getTypeName().contains("Ð¡Ð¿ÐµÑ\u0086Ð°ÐºÑ\u0086Ð¸Ð¸")) {


                    model.addAttribute("listTypes", countNews.countNewsList(3));
                }
                else if (types.getTypeName().
                        contains("Ð\u009EÑ\u0084Ð¸Ñ\u0086Ð¸Ð°Ð»Ñ\u008CÐ½Ñ\u008BÐ¹ Ñ\u0082ÐµÐºÑ\u0081Ñ\u0082")) {


                    model.addAttribute("listTypes", countNews.countNewsList(4));
                }
                else if (types.getTypeName().
                        contains("Ð\u0090Ð½Ð³Ð»Ð¸Ð¹Ñ\u0081ÐºÐ¸Ð¹ Ñ\u0082ÐµÐºÑ\u0081Ñ\u0082")) {


                    model.addAttribute("listTypes", countNews.countNewsList(5));
                }
            }
            return val;
        }
        private void initModelList(Model model) {
            List<String> typesList = new ArrayList<String>();
            typesList.add("Выберите тип");
            typesList.add(typesDAO.list().get(0).getName());
            typesList.add(typesDAO.list().get(1).getName());
            typesList.add(typesDAO.list().get(2).getName());
            typesList.add(typesDAO.list().get(3).getName());
            typesList.add(typesDAO.list().get(4).getName());
            model.addAttribute("typesList", typesList);
        }
}
