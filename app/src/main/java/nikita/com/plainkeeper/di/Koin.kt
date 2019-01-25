package nikita.com.plainkeeper.di

import nikita.com.plainkeeper.network.Api
import org.koin.dsl.module.module
import retrofit2.Retrofit

val plainKeeperModule = module {
    single<Api> { get<Retrofit>().create(Api::class.java) }
}