package com.ieasy.validator.group;

import javax.validation.GroupSequence;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.ValidatorUtils.group
 * @description 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @className AllGroup
 * @createDate 2019-03-19 10:35 PM
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface AllGroup {
}
