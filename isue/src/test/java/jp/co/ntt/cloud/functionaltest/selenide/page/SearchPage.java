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
package jp.co.ntt.cloud.functionaltest.selenide.page;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/*
 * Helloページのページオブジェクトクラス。
 */
public class SearchPage {

    /**
     * ログアウトする。
     * @return TopPage トップページ
     */
    public TopPage logout(){
        $("button").click();
        return new TopPage();
    }

    /**
     * ログイン状態を返却する。
     * @return boolean ログイン状態
     */
    public boolean isLoggedIn() {
        if ($(byId("wrapper")).$(byText("Logout")).exists()) {
            return true;
        }
        return false;
    }

    
    public SearchPage searchByPk(String objectKey) {
        $(byId("objectKey")).clear();
        $(byId("objectKey")).setValue(objectKey);
        $$("tr").get(3).$("button").click();
        return new SearchPage();
    }
    
    public SearchPage searchByIndex_uploadUser_uploadDate(
    		String uploadUser, String uploadDate) {
        $(byId("uploadUser")).clear();
        $(byId("uploadUser")).setValue(uploadUser);
        $(byId("uploadDate")).clear();
        $(byId("uploadDate")).setValue(uploadDate);
        $$("tr").get(3).$("button").click();
        return new SearchPage();
    }

    public SearchPage searchByIndex_bucketName(String bucketName) {
        $(byId("bucketName")).selectOption(bucketName);
        $$("tr").get(3).$("button").click();
        return new SearchPage();
    }
}
