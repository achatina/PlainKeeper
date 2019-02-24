package nikita.com.plainkeeper.di

import nikita.com.plainkeeper.auth.AuthDataSource
import nikita.com.plainkeeper.auth.AuthPresenter
import nikita.com.plainkeeper.auth.AuthPresenterImpl
import nikita.com.plainkeeper.auth.AuthRepository
import nikita.com.plainkeeper.network.Api
import nikita.com.plainkeeper.session.SessionDataSource
import nikita.com.plainkeeper.session.SessionRepository
import org.koin.dsl.module.module
import retrofit2.Retrofit

val plainKeeperModule = module {
    single<Api> { get<Retrofit>().create(Api::class.java) }
}

val authModule = module {
    factory<AuthPresenter> { AuthPresenterImpl() }
    single<AuthRepository> { AuthDataSource(get()) }
}

val sessionModule = module {
    single<SessionRepository> { SessionDataSource(get()) }
}