//
//  MovieListViewModel.swift
//  iosApp
//
//  Created by Ahmed Orabi on 21/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared


class MovieListViewModel : ObservableObject {
    
    let getMovieUseCase : GetMoviesUseCase
    
    @Published var state : MovieListState = MovieListState()
    
    init(getMovieUseCase : GetMoviesUseCase) {
        self.getMovieUseCase = getMovieUseCase
        getMovies()
    }
    
    func triggerEvent(){
        
    }
    
    func getMovies(){
        let currentState = (self.state.copy() as! MovieListState)
        
        do {
            try getMovieUseCase.execute(page: 1).collectCommon(coroutineScope: nil, callback: { dateState in
                if dateState != nil{
                    let data = dateState?.data
                    
                    if data != nil{
                        self.appendMovies(movies: data as! MovieResponse)
                    }
        
                }
            })
        } catch  {
            print("\(error)")
        }
    }
    
    func appendMovies(movies : MovieResponse){
        let results = movies.results
        let currentState = (self.state.copy() as! MovieListState)
        
        self.state = self.state.doCopy(isLoading: currentState.isLoading, page: currentState.page, query: currentState.query, movies: results)
        
    }
}
