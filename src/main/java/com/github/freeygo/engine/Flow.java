/*
 * Copyright (c) 2020 free-ygo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.freeygo.engine;

import com.github.freeygo.engine.cmd.flow.FlowAction;

import java.util.Objects;

/**
 * @author Zhiyong Dai
 */
public class Flow implements Comparable<Flow> {

    private int order; // 流程顺序
    private int flag; // 流程标志
    private String name; // 流程名字
    private FlowAction flowAction;

    public Flow(int order, int flag, String name, FlowAction flowAction) {
        this.order = order;
        this.flag = flag;
        this.name = name;
        this.flowAction = flowAction;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowAction getFlowAction() {
        return flowAction;
    }

    public void setFlowAction(FlowAction flowAction) {
        this.flowAction = flowAction;
    }

    @Override
    public int compareTo(Flow o) {
        return Integer.compare(order, o.order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flow)) return false;
        Flow flow = (Flow) o;
        return order == flow.order &&
                flag == flow.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, flag);
    }
}
