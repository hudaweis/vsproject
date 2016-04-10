package com.vshuok.es.showcase.product.web.controller;

import com.vshuok.es.common.entity.enums.BooleanEnum;
import com.vshuok.es.common.entity.search.Searchable;
import com.vshuok.es.common.plugin.web.controller.BaseMovableController;
import com.vshuok.es.common.web.bind.annotation.PageableDefaults;
import com.vshuok.es.showcase.product.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/showcase/product/category")
public class CategoryController extends BaseMovableController<Category, Long> {


    public CategoryController() {
        setResourceIdentity("showcase:productCategory");
    }

    @Override
    protected void setCommonData(Model model) {
        model.addAttribute("booleanList", BooleanEnum.values());
    }


    //selectType  multiple single
    @RequestMapping(value = {"select/{selectType}", "select"}, method = RequestMethod.GET)
    @PageableDefaults(sort = "weight=desc")
    public String select(
            Searchable searchable, Model model,
            @PathVariable(value = "selectType") String selectType,
            @MatrixVariable(value = "domId", pathVar = "selectType") String domId,
            @MatrixVariable(value = "domName", pathVar = "selectType", required = false) String domName) {

        this.permissionList.assertHasViewPermission();

        model.addAttribute("selectType", selectType);
        model.addAttribute("domId", domId);
        model.addAttribute("domName", domName);

        super.list(searchable, model);
        return "showcase/product/category/select";
    }
}
