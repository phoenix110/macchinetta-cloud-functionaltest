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
package jp.co.ntt.cloud.functionaltest.domain.service.login;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import jp.co.ntt.cloud.functionaltest.domain.model.Account;
import jp.co.ntt.cloud.functionaltest.domain.repository.login.AccountRepository;

/**
 * ログイン業務共通サービス実装クラス。
 * @author NTT 電電太郎
 */
@Service
public class AccountSharedServiceImpl implements AccountSharedService {

    /**
     * ユーザアカウントリポジトリ。
     */
    @Inject
    AccountRepository accountRepository;

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public Account findOne(String userId) {

        Account account = accountRepository.findOne(userId);

        if (account == null) {
            throw new ResourceNotFoundException("The given account is not found! userId="
                    + userId);
        }
        return account;
    }

}
