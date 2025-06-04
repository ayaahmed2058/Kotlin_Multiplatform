import SwiftUI
import Combine

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticleViewModel


        init() {
            self.articlesViewModel = ArticleInjector().articleViewModel
            self.articlesState = articlesViewModel.articles.value
        }

        @Published var articlesState: ArticleState

        func startObserving() {
            Task {
                for await article in articlesViewModel.articles {
                    self.articlesState = article
                }
            }
        }
    }
}
