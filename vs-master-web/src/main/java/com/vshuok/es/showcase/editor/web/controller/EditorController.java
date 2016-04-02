package com.vshuok.es.showcase.editor.web.controller;

import com.vshuok.es.common.web.controller.BaseCRUDController;
import com.vshuok.es.showcase.editor.entity.Editor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/showcase/editor")
public class EditorController extends BaseCRUDController<Editor, Long> {

    public EditorController() {
        setResourceIdentity("showcase:editor");
    }

    /**
     * 验证失败返回true
     *
     * @param m
     * @param result
     * @return
     */
    @Override
    protected boolean hasError(Editor m, BindingResult result) {
        Assert.notNull(m);

        return result.hasErrors();
    }


}
