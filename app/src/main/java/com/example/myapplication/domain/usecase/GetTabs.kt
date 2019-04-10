package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.MainRepository
import com.example.myapplication.domain.entity.TabListEntity
import javax.inject.Inject


/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class GetTabs @Inject constructor(
    private val mainRepository: MainRepository
) : UseCase<Unit, TabListEntity?>() {
    override fun execute(parameters: Unit): TabListEntity? {
        val getTabs = mainRepository.getTabs() ?: return null
        return getTabs
    }

}