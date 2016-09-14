package com.my.smlr.service

import org.junit.Assert
import org.junit.Test

class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "aAbBcCdD"
    private val LINK: String = "http://www.eveonline.com"
    private val LINK_NEW: String = "http://wow.ru"

    @Test
    fun clientCanAddNewKeyWithLink(){
        Assert.assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        Assert.assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey(){
        service.add(KEY, LINK)
        Assert.assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        Assert.assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService(){
        Assert.assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }
}