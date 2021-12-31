//
//  SearchAppBar.swift
//  iosApp
//
//  Created by Ahmed Orabi on 31/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchAppBar: View {
    
    
    @State var query : String = ""
    private let onTriggerEent : (MovieListEvents) -> Void
    
    
    init(query : String , onTriggerEvent  : @escaping (MovieListEvents) -> Void){
        self.onTriggerEent = onTriggerEvent
        self._query = State(initialValue: query)
    }
    
    var body: some View {
        VStack{
            HStack{
                Image(systemName: "magnifyingglass")
                TextField(
                 "Search...",
                 text: $query,
                 onCommit: {
                     onTriggerEent(MovieListEvents.SearchMovie())
                 }
                )
                .onChange(of: query, perform: { value in
                    onTriggerEent(MovieListEvents.OnUpdateQuery(query : value))
            })
            }
            .padding(.bottom,4)
        }
        .padding(.top,4)
        .padding(.leading,4)
        .padding(.trailing,4)
        .background(Color.white.opacity(0))
    }
}

