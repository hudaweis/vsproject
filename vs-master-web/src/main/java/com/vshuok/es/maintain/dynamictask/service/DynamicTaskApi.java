package com.vshuok.es.maintain.dynamictask.service;

import com.vshuok.es.maintain.dynamictask.entity.TaskDefinition;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface DynamicTaskApi {

    public void addTaskDefinition(TaskDefinition taskDefinition);
    public void updateTaskDefinition(TaskDefinition taskDefinition);
    public void deleteTaskDefinition(boolean forceTermination, Long... taskDefinitionIds);


    public void startTask(Long... taskDefinitionIds);
    public void stopTask(boolean forceTermination, Long... taskDefinitionId);


}
