/*
 * Copyright 2014-2018 NTT Corporation.
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
package jp.co.ntt.cloud.functionaltest.domain.service.caap;

/**
 * AWS向け開発プロジェクト確認用モデル。
 * @author NTT 電電太郎
 */
public class CaapProjectInfo {

    private boolean existFQCNClasspath;

    private boolean existInApplicationContext;

    public boolean isExistFQCNClasspath() {
        return existFQCNClasspath;
    }

    public void setExistFQCNClasspath(boolean existFQCNClasspath) {
        this.existFQCNClasspath = existFQCNClasspath;
    }

    public boolean isExistInApplicationContext() {
        return existInApplicationContext;
    }

    public void setExistInApplicationContext(
            boolean existInApplicationContext) {
        this.existInApplicationContext = existInApplicationContext;
    }
}
