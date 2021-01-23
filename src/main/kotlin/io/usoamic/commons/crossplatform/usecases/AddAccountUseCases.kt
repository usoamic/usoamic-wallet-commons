package io.usoamic.commons.crossplatform.usecases

import io.reactivex.Single
import io.usoamic.wallet.commons.models.add.AddAccountModel
import io.usoamic.wallet.commons.repositories.api.EthereumRepository
import io.usoamic.wallet.commons.repositories.api.ValidateRepository
import javax.inject.Inject

class AddAccountUseCases @Inject constructor(
    private val mValidateRepository: ValidateRepository,
    private val mEthereumRepository: EthereumRepository
) {
    fun addAccount(
        privateKey: String,
        password: String,
        confirmPassword: String
    ): Single<AddAccountModel> {
        return mValidateRepository.validatePrivateKey(privateKey)
            .andThen(
                mValidateRepository.validatePasswords(password, confirmPassword)
            )
            .andThen(
                mEthereumRepository.addAccount(privateKey, password)
            )
    }
}