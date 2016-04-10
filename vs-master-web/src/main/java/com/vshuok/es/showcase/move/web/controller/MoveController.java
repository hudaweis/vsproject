package com.vshuok.es.showcase.move.web.controller;

import com.vshuok.es.common.entity.enums.BooleanEnum;
import com.vshuok.es.common.entity.validate.group.Create;
import com.vshuok.es.common.plugin.web.controller.BaseMovableController;
import com.vshuok.es.showcase.move.entity.Move;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/showcase/move")
public class MoveController extends BaseMovableController<Move, Long> {


    public MoveController() {
        setResourceIdentity("showcase:move");
    }

    public void setCommonData(Model model) {
        model.addAttribute("booleanList", BooleanEnum.values());
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    @Override
    public String create(Model model,
                         //表示只验证Create.class分组
                         @Validated(value = Create.class) @Valid Move move, BindingResult result,
                         RedirectAttributes redirectAttributes) {
        return super.create(model, move, result, redirectAttributes);
    }

}
