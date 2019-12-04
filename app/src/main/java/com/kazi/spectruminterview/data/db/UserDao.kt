package  com.kazi.test.data.db

import androidx.room.*
import com.kazi.spectruminterview.data.db.entities.Company
import com.kazi.spectruminterview.data.db.entities.Member

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<Company>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(user: List<Member>): List<Long>

    @Query("SELECT * from Company")
    suspend fun getAllEmployee(): List<Company>

    @Update
    suspend fun update(employee: Company): Int


}