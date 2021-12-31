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
    let searchMovieUseCase : SearchMoviesUseCase
    
    @Published var state : MovieListState = MovieListState()
    
    init(getMovieUseCase : GetMoviesUseCase , searchMovieUseCase : SearchMoviesUseCase) {
        self.getMovieUseCase = getMovieUseCase
        self.searchMovieUseCase = searchMovieUseCase
        onTriggerEvents(stateEvent : MovieListEvents.LoadMovies())
    }
    
    func onTriggerEvents(stateEvent : MovieListEvents){
        switch stateEvent {
        case is MovieListEvents.LoadMovies:
            getMovies()
        case is MovieListEvents.OnUpdateQuery:
            onUpdateQuery(query: (stateEvent as! MovieListEvents.OnUpdateQuery).query)
        case is MovieListEvents.SearchMovie:
            searchMovie()
        default:
            doNoThing()
        }
    }
    
    func resetSearch(){
        let currentState = (self.state.copy() as! MovieListState)

        self.state = self.state.doCopy(
            isLoading:  currentState.isLoading,
            page: 1,
            query: currentState.query,
            movies:[]
        )

    }
    
    func onUpdateQuery(query : String){
        updateState(query: query)
    }
    
    func doNoThing(){
        
    }
    
    func getMovies(isLoading : Bool? = nil, page : Int? = nil ,
                   query : String? = nil){
        let currentState = (self.state.copy() as! MovieListState)
        
        do {
            try getMovieUseCase.execute(page: currentState.page).collectCommon(coroutineScope: nil, callback: { dateState in
                if dateState != nil{
                    let isLoading = dateState?.isLoading  ?? false
                    
                    self.updateState(isLoading: isLoading)
                    
                    let data = dateState?.data
                    let message = dateState?.message
                    
                    if data != nil{
                        self.appendMovies(movies: data as! MovieResponse)
                    }
                    
                    if message != nil{
                        print(message)
                    }
        
                }
            })
        } catch  {
            print("\(error)")
        }
    }
    
    func searchMovie(isLoading : Bool? = nil, page : Int? = nil ,
                   query : String? = nil){
        resetSearch()
        let currentState = (self.state.copy() as! MovieListState)
        
        do {
            try searchMovieUseCase.execute(query: state.query).collectCommon(coroutineScope: nil, callback: { dateState in
                if dateState != nil{
                    let isLoading = dateState?.isLoading  ?? false
                    
                    self.updateState(isLoading: isLoading)
                    
                    let data = dateState?.data
                    let message = dateState?.message
                    
                    if data != nil{
                        self.appendMovies(movies: data as! MovieResponse)
                    }
                    
                    if message != nil{
                        print(message)
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
    
    private func updateState(
         isLoading: Bool? = nil,
         page: Int? = nil,
         query: String? = nil
     ){
         let currentState = (self.state.copy() as! MovieListState)
         self.state = self.state.doCopy(
             isLoading: isLoading ?? currentState.isLoading,
             page: Int32(page ?? Int(currentState.page)),
             query: query ?? currentState.query,
             movies: currentState.movies
            )
     }
}
