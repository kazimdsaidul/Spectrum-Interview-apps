package com.kazi.test.data.repository


import com.kazi.spectruminterview.data.db.entities.Company
import com.kazi.spectruminterview.data.db.entities.Member
import com.kazi.test.data.db.AppDatabase
import com.kazi.test.data.network.APIService
import com.kazi.test.data.network.SafeApiRequest

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
class UserRepository(
    private val apiService: APIService,
    private val db: AppDatabase

) : SafeApiRequest() {

    suspend fun getEmployeesAPI(): List<Company> {
        return apiRequest { apiService.getEmployees() }
    }

    suspend fun saveAPIDataToLocalDB(user: List<Company>) {
        val memberList = mutableListOf<Member>()
        user.forEach { c ->
            run {
                c.members.forEach {
                    it.companyId = c._id
                    memberList.add(it)
                }
            }
        }
        db.getUserDao().insertMember(memberList)
        db.getUserDao().insert(user)
    }

    suspend fun getEmployeesLocal(): List<Company> {
        return db.getUserDao().getAllEmployee()
    }

    suspend fun update(employee: Company): Int {
        return db.getUserDao().update(employee)
    }
}