import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';

export interface IMaison {
  id?: number;
  adresse?: string;
  cheminPhotoMaison?: string | null;
  nbrePiece?: number;
  disponibilite?: boolean;
  prixLocation?: number;
  proprietaire?: string;
  applicationUser?: IApplicationUser | null;
  utilisateur?: IUtilisateur | null;
}

export const defaultValue: Readonly<IMaison> = {
  disponibilite: false,
};
