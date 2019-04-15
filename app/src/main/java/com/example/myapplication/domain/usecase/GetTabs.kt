package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.MainRepository
import com.example.myapplication.domain.entity.TabListEntity
import com.example.myapplication.presentation.TabData
import javax.inject.Inject


/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class GetTabs @Inject constructor(
    private val mainRepository: MainRepository
) : UseCase<Unit, List<TabData>?>() {
    override fun execute(parameters: Unit): List<TabData>? {
        val getTabs = mainRepository.getTabs() ?: return null

        val tabData = mutableListOf<TabData>()
        getTabs.apiGroups?.affiliate?.apiListings?.forEach {
            val key = it.key
            val value = it.value
            tabData.add(
                TabData(
                    key,
                    value.version1?.version1?.getPhotos
                )
            )
        }

        return tabData
    }

}