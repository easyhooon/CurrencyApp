package di

import com.russhwolf.settings.Settings
import data.remote.api.CurrencyApiServiceImpl
import data.remote.local.MongoImpl
import data.remote.local.PreferencesImpl
import domain.CurrencyApiService
import domain.MongoRepository
import domain.PreferencesRepository
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.screen.HomeViewModel

val appModule = module {
    single { Settings() }
    // 타입을 지정해주지 않으면 에러가 발생함
    single<MongoRepository> { MongoImpl() }
    single<PreferencesRepository> { PreferencesImpl(settings = get()) }
    single<CurrencyApiService> { CurrencyApiServiceImpl(preferences = get()) }
    factory {
        HomeViewModel(
            preferences = get(),
            mongoDb = get(),
            api = get(),
        )
    }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}