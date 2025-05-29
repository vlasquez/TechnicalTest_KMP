//
// Created by Andrés Velasquez on 28/05/25.
// Copyright (c) 2025 orgName. All rights reserved.
//

import Foundation
import shared

class DIModule {
    static var koin = {
        Koin().doInit(
            appDeclaration: { _ in
                // Do nothing
            }
        )
    }()
}